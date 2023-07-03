<?php

namespace App\Form;

use App\Entity\Category;
use App\Entity\Game;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Validator\Constraints\File;

class GameType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder->add('gameName')->add('gameDescription', TextareaType::class)->add('gameLink')->add('gameImg',FileType::class,array('data_class' => null))->add('idcategory', EntityType::class, ['class' => Category::class, 'choice_label' => 'category_name']);
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults(['data_class' => Game::class,]);
    }
}
