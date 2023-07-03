<?php

namespace App\Controller;

use App\Entity\Category;
use App\Entity\Game;
use App\Form\GameType;
use App\Repository\GameRepository;
use Doctrine\ORM\EntityManagerInterface;
use Exception;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\HiddenType;
use Symfony\Component\HttpFoundation\File\Exception\FileException;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;


/**
 * @Route("/game")
 */
class GameController extends AbstractController
{


    /**
     * @Route("/searchG", name="search_games", methods={"GET"})
     */
    public function searchG(Request $request,GameRepository $repository, $value, PaginatorInterface $paginator): Response
    {
        $em=$this->getDoctrine()->getManager();
        $games = $em->getRepository(Game::class)->findAll();

        $pagination = $paginator->paginate(
            $games,
            $request->query->getInt('page', 1),
            5
        );
        if($request->isMethod("POST")){
            $name = $request->get('gameName');
              $games = $repository->findByExampleField($name);
            $pagination = $paginator->paginate(
                $games,
                $request->query->getInt('page', 1),
                5
            );
            return $this->render('game/list.html.twig', ['games' => $pagination]);
        }
        return $this->render('game/list.html.twig', ['games' => $pagination]);

    }

    /**
     * @Route("/mobile/edit",name="edit_mobile_game")
     */
    public function editMobile(Request $request)
    {
        $id = $request->query->get("id");
        $name = $request->query->get("name");
        $description = $request->query->get("description");
        $link = $request->query->get("link");
        $image = $request->query->get('image');

        $game = $this->getDoctrine()->getRepository(Game::class)->findOneBy(['gameId' => $id]);
        $game->setGameName($name);
        $game->setGameLink($link);
        $game->setGameDescription($description);
        $game->setGameImg($image);
        try {
            $em = $this->getDoctrine()->getManager();
            $em->flush();
            return new JsonResponse("game edited");
        } catch (Exception $e) {
            return new JsonResponse("error while editing game");
        }
    }



    /**
     * @Route("/", name="app_game_index")
     */
    public function index( Request $request,GameRepository $repository, PaginatorInterface $paginator): Response
    {
        $em=$this->getDoctrine()->getManager();
        $games = $em->getRepository(Game::class)->findAll();

        if($request->isMethod("POST")){
            $name = $request->get('gameName');
            $games = $repository->findByExampleField($name);
        }
        $pagination = $paginator->paginate(
            $games,
            $request->query->getInt('page', 1),
            5
        );
        return $this->render('game/index.html.twig', ['games' => $pagination]);
    }

    /**
     * @Route("/front", name="app_game_index_front", methods={"GET"})
     */
    public function indexFront(EntityManagerInterface $entityManager, Request $req, PaginatorInterface $paginator): Response
    {
        $games = $entityManager->getRepository(Game::class)->findAll();

        $pagination = $paginator->paginate(
            $games,
            $req->query->getInt('page', 1),
            6
        );
        return $this->render('game/index_front.html.twig', ['games' => $pagination,]);
    }

    /**
     * @Route("/new", name="app_game_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $game = new Game();
        $form = $this->createForm(GameType::class, $game);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $file = $form->get('gameImg')->getData();
            if ($file) {
                // this is needed to safely include the file name as part of the URL
                $newFilename = uniqid() . '.' . $file->guessExtension();
                // Move the file to the directory where pictures are stored
                try {
                    $file->move(
                        $this->getParameter('games_pictures'),
                        $newFilename
                    );
                } catch (FileException $e) {
                    // ... handle exception if something happens during file upload
                }

                // updates the 'brochureFilename' property to store the PDF file name
                // instead of its contents
                $game->setGameImg($newFilename);
            }
            $entityManager->persist($game);
            $entityManager->flush();

            return $this->redirectToRoute('app_game_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('game/new.html.twig', ['game' => $game, 'form' => $form->createView(),]);
    }

    /**
     * @Route("/{gameId}/rate", name="app_game_rate", methods={"GET", "POST"})
     */
    public function show(Game $game, Request $request, EntityManagerInterface $entityManager): Response
    {

        $form = $this->createFormBuilder($game)->add('rating',HiddenType::class)->getForm();
        $form->handleRequest($request);
        $rating = $form->get('rating')->getData();

        if ($form->isSubmitted()) {
            $game->setRating($rating);
            $entityManager->flush();

            return $this->redirectToRoute('app_game_rate', ['gameId'=> $game->getGameId()], Response::HTTP_SEE_OTHER);
        }
        return $this->render('game/single_product.html.twig', ['game' => $game, 'form' => $form->createView(),]);
    }

    /**
     * @Route("/{gameId}/edit", name="app_game_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Game $game, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(GameType::class, $game);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $file = $form->get('gameImg')->getData();
            if ($file) {
                // this is needed to safely include the file name as part of the URL
                $newFilename = uniqid() . '.' . $file->guessExtension();
                // Move the file to the directory where pictures are stored
                try {
                    $file->move(
                        $this->getParameter('games_pictures'),
                        $newFilename
                    );
                } catch (FileException $e) {
                    // ... handle exception if something happens during file upload
                }

                // updates the 'brochureFilename' property to store the PDF file name
                // instead of its contents
                $game->setGameImg($newFilename);
            }
            $entityManager->flush();

            return $this->redirectToRoute('app_game_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('game/edit.html.twig', ['game' => $game, 'form' => $form->createView(),]);
    }

    /**
     * @Route("/{gameId}", name="app_game_delete", methods={"POST"})
     */
    public function delete(Request $request, Game $game, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete' . $game->getGameId(), $request->request->get('_token'))) {
            $entityManager->remove($game);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_game_index', [], Response::HTTP_SEE_OTHER);
    }



    /**
     * @Route("/orderBYName", name="orderbyName", methods={"GET"})
     */
    public function orderbyNameGame(gameRepository $gameRepository, PaginatorInterface $paginator, Request $request): Response
    {

        $games = $this->getDoctrine()->getManager()->createQuery('SELECT p FROM App\Entity\game p order by  p.game_name asc')->getResult();
        $game = $paginator->paginate($games, $request->query->getInt('page', 1), 2

        );


        return $this->render('game/list.html.twig', ['games' => $game// ,'user'=>$this->getUser()

        ]);
    }


    /**
     * @Route("/mobile/add", name="add_mobile_game")
     */
    public function addGame(Request $request)
    {
        $id = $request->query->get("idCategory");
        $category = $this->getDoctrine()->getRepository(Category::class)->findOneBy(["categoryId" => $id]);
        $name = $request->query->get("name");
        $description = $request->query->get("description");
        $link = $request->query->get("link");
        $image = $request->query->get('image');

        $game = new Game();
        $game->setGameName($name);
        $game->setIdcategory($category);
        $game->setGameLink($link);
        $game->setGameDescription($description);

        $game->setGameImg($image);

        try {
            $em = $this->getDoctrine()->getManager();
            $em->persist($game);
            $em->flush();
            return new JsonResponse("game added");
        } catch (Exception $e) {
            return new JsonResponse("error while adding game : " . $e->getMessage());
        }
    }

    /**
     * @Route("/mobile/getAll",name="get_mobile_game")
     */
    public function showGames(): Response
    {
        $games = $this->getDoctrine()->getRepository(Game::class)->findAll();
        $gamesList = [];
        foreach ($games as $g) {
            $gamesList[] = ['id' => $g->getGameId(), 'name' => $g->getGameName(), 'description' => $g->getGameDescription(), 'link' => $g->getGameLink(), 'image' => $g->getGameImg()];

        }
        return new Response(json_encode($gamesList));

    }

    /**
     * @Route("/mobile/delete", name="delete_mobile_game")
     */
    public function deleteGame(Request $request)
    {
        $id = $request->query->get('id');
        $game = $this->getDoctrine()->getRepository(Game::class)->findOneBy(['gameId' => $id]);

        try {
            $em = $this->getDoctrine()->getManager();
            $em->remove($game);
            $em->flush();
            return new JsonResponse("game deleted successfully");
        } catch (Exception $e) {
            return new JsonResponse("error on " . $e->getMessage());
        }
    }
    /*
    /**
     * @Route("/statsT", name="statsT")
     *
    public function statistiques( TournoiRepository  $repository)
    {

        $offs = $repository->countByDate();

        $DateDebutOffres = [];
        $offCount = [];

        // On "démonte" les données pour les séparer tel qu'attendu par ChartJS
        foreach($offs as $off){
            $DateDebutOffres[] = $off['dateev'];
            $offCount[] = $off['count'];
        }

        return $this->render('game/stats.html.twig', [
            'DateDebutOffres' => json_encode($DateDebutOffres),
            'offCount' => json_encode($offCount),'user'=>$this->getUser(),

        ]);
    }*/
}
