<?php

namespace App\Entity;

use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Doctrine\ORM\Mapping\JoinColumn;
use Symfony\Component\Serializer\Annotation\Groups;
use Symfony\Component\Validator\Constraints as Assert;


/**
 * Category
 *
 * @ORM\Table(name="category", uniqueConstraints={@ORM\UniqueConstraint(name="category_name", columns={"category_name"})})
 * @ORM\Entity
 */
class Category
{
    /**
     * @var int
     *
     * @ORM\Column(name="category_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $categoryId;

    /**
     * @var int
     *    @Assert\NotBlank(message="veuillez saisir le nom du categorie")
     *     @Assert\Length(
     *     min=3,
     *     max=30,
     *     minMessage = "le nom du categorie doit etre supérieur a 4 caracteres",
     *     maxMessage  ="le nom du categorie ne doit pas depasser 30 caracteres",
     *     allowEmptyString = false
     *     )
     * @ORM\Column(name="category_name", type="string", nullable=false)
     */
    private $categoryName;

    /**
     * @var int
    * @Assert\NotBlank(message="la description est  obligatoire")

     * @ORM\Column(name="discription", type="string", nullable=false)
     */
    private $discription;

    /**
     * @ORM\OneToMany(targetEntity=Game::class, mappedBy="idcategory",cascade={"persist", "remove"})
     */
    private $games;

    /**
     * @return Collection|Game[]
     */
    public function getGames(): Collection
    {
        return $this->games;
    }

    public function addGames(Game $game): self
    {
        if (!$this->games->contains($game)) {
            $this->games[] = $game;
            $game->setIdcategory($this);
        }

        return $this;
    }

    public function removeGame(Game $game): self
    {
        if ($this->games->removeElement($game)) {
            // set the owning side to null (unless already changed)
            if ($game->getIdcategory() === $this) {
                $game->setIdcategory(null);
            }
        }

        return $this;
    }



    /**
     * Get the value of categoryId
     *
     * @return  int
     */
    public function getCategoryId()
    {
        return $this->categoryId;
    }

    /**
     * Set the value of categoryId
     *
     * @param  int  $categoryId
     *
     * @return  self
     */
    public function setCategoryId(int $categoryId)
    {
        $this->categoryId = $categoryId;

        return $this;
    }

    /**
     * Get the value of categoryName
     *
     * @return  string
     */
    public function getCategoryName()
    {
        return $this->categoryName;
    }

    /**
     * Set the value of categoryName
     *
     * @param  string  $categoryName
     *
     * @return  self
     */
    public function setCategoryName(string $categoryName)
    {
        $this->categoryName = $categoryName;

        return $this;
    }

    /**
     * Get the value of discription
     *
     * @return  string
     */
    public function getDiscription()
    {
        return $this->discription;
    }

    /**
     * Set the value of discription
     *
     * @param  string  $discription
     *
     * @return  self
     */
    public function setDiscription(string $discription)
    {
        $this->discription = $discription;

        return $this;
    }
}
