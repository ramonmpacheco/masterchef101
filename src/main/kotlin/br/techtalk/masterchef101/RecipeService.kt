package br.techtalk.masterchef101

import org.springframework.stereotype.Service

@Service
class RecipeService(private val repository: RecipeRepository) {
    fun save(recipe: Recipe): Recipe = repository.save(recipe)
}