package br.techtalk.masterchef101

import org.springframework.stereotype.Service
import java.util.*

@Service
class RecipeService(private val repository: RecipeRepository) {
    fun save(recipe: Recipe): Recipe = repository.save(recipe)
    fun findById(id: Long): Optional<Recipe> = repository.findById(id)
}