<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Doctrine\ORM\Mapping\JoinColumn;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Component\Serializer\Annotation\{Groups};
use App\Entity\Category;


/**
 * Game
 *
 * @ORM\Table(name="Game", indexes={@ORM\Index(name="FK_category_id", columns={"idcategory"})})
 * @ORM\Entity
 */
class Game
{
    /**
     * @var int
     *
     * @ORM\Column(name="game_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $gameId;

    /**
     * @var string
     * @Assert\NotBlank(message="veuillez saisir le nom du jeu")
     * @Assert\Length(
     *     min=6,
     *     minMessage = "le nom du jeu doit etre supérieur a 4 caracteres",
     *     allowEmptyString = false
     *     )
     * @ORM\Column(name="game_name", type="string", length=255, nullable=false)
     */
    private $gameName;

    /**
     * @var string
     * @Assert\NotBlank(message="la description  est  obligatoire")
     * @ORM\Column(name="game_description", type="string", length=255, nullable=false)
     */
    private $gameDescription;

    /**
     * @var string
     * @Assert\NotBlank(message="le lien  est  obligatoire")
     * @ORM\Column(name="game_link", type="string", length=255, nullable=false)
     */
    private $gameLink;

    /**
     * @var string
     * @Assert\NotBlank(message="l'image est  obligatoire")
     * @ORM\Column(name="game_img", type="string", length=255, nullable=false)
     */
    private $gameImg;

    /**
     * @var \Category
     * @Assert\NotBlank(message="la category est  obligatoire")
     * @ORM\ManyToOne(targetEntity=Category::class, inversedBy="games")
     * @ORM\JoinColumn(name="idcategory", referencedColumnName="category_id")
     */
    private $idcategory;
    /**
     * @ORM\Column(type="integer", nullable=true)
     * @Groups("post:read")
     * @Assert\Positive
     *
     */
    private $nbr_vu;

    /**
     * @ORM\Column(type="integer", nullable=true)
     */
    private $rating;


    public function getNbrVu()
    {
        return $this->nbr_vu;
    }


    public function setNbrVu($nbr_vu): void
    {
        $this->nbr_vu = $nbr_vu;
    }


    /**
     * Get the value of gameId
     *
     * @return  int
     */
    public function getGameId()
    {
        return $this->gameId;
    }

    /**
     * Set the value of gameId
     *
     * @param int $gameId
     *
     * @return  self
     */
    public function setGameId(int $gameId)
    {
        $this->gameId = $gameId;

        return $this;
    }

    /**
     * Get the value of gameName
     *
     * @return  string
     */
    public function getGameName()
    {
        return $this->gameName;
    }

    /**
     * Set the value of gameName
     *
     * @param string $gameName
     *
     * @return  self
     */
    public function setGameName(string $gameName)
    {
        $this->gameName = $gameName;

        return $this;
    }

    /**
     * Get the value of gameDescription
     *
     * @return  string
     */
    public function getGameDescription()
    {
        return $this->gameDescription;
    }

    /**
     * Set the value of gameDescription
     *
     * @param string $gameDescription
     *
     * @return  self
     */
    public function setGameDescription(string $gameDescription)
    {
        $this->gameDescription = $gameDescription;

        return $this;
    }

    /**
     * Get the value of gameDescription
     *
     * @return  string
     */
    public function getGameLink()
    {
        return $this->gameLink;
    }

    /**
     * @param string $gameLink
     * @return  self
     */
    public function setGameLink(string $gameLink)
    {
        $this->gameLink = $gameLink;

        return $this;
    }

    /**
     * @return  string
     */
    public function getGameImg()
    {
        return $this->gameImg;
    }

    /**
     * @param string $gameImg
     * @return  self
     */
    public function setGameImg(string $gameImg)
    {
        $this->gameImg = $gameImg;

        return $this;
    }

    public function getIdcategory(): ?Category
    {
        return $this->idcategory;
    }

    public function setIdcategory(?Category $category): self
    {
        $this->idcategory = $category;

        return $this;
    }

    public function getRating(): ?int
    {
        return $this->rating;
    }

    public function setRating(?int $rating): self
    {
        $this->rating = $rating;

        return $this;
    }
}
