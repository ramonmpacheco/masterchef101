package br.techtalk.masterchef101.acceptance.steps

import br.techtalk.masterchef101.Recipe
import br.techtalk.masterchef101.RecipeService
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.spring.CucumberContextConfiguration
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertNotNull
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@CucumberContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
class RecipeSteps(private val recipeService: RecipeService) {
    private var createdRecipe: Recipe? = null
    private lateinit var currentRecipe: Recipe
    private lateinit var currentRecipes: MutableList<Recipe>

    @Given("que estou a criar uma receita")
    fun `i am creating a recipe`() {
        currentRecipe = Recipe()
    }

    @Given("que estou a criar varias receitas")
    fun `i am creating recipes`() {
        `i am creating a recipe`()
        currentRecipes = mutableListOf()
    }

    @And("informo o nome do receita {string}")
    fun `inform the recipe name`(name: String) {
        currentRecipe.name = name
    }

    @And("informo a descricao da receita {string}")
    fun `inform the recipe description`(desc: String) {
        currentRecipe.description = desc
    }

    @And("classifico com estrelas {int}")
    fun `inform the recipe description`(stars: Int) {
        currentRecipe.stars = stars
    }

    @And("adiciono a receita na lista")
    fun `add recipe to the list`() {
        currentRecipes.add(currentRecipe)
    }

    @When("envio os dados da receita")
    fun `send the recipe data`() {
        createdRecipe = recipeService.save(currentRecipe)
    }

    @When("envio a lista com os dados da receita")
    fun `send recipe data list`(){
        currentRecipes.forEach {  createdRecipe=recipeService.save(it) }
    }

    @Then("a receita deve ser criada")
    fun `the recipe must be created`() {
        assertNotNull(createdRecipe)
        assertEquals(currentRecipe, createdRecipe)
    }

    @Then("as receitas devem ser criadas {string}")
    fun `the recipes must be created`(name: String) {
        val recipe = recipeService.findById(createdRecipe?.id ?: 0)
        assertTrue(recipe.isPresent)
        assertEquals(name, recipe.get().name)
    }

    @Then("a classificacao deve ser salva")
    fun `the classification must be saved`(){
        assertNotNull(createdRecipe)
        assertTrue(createdRecipe?.stars!! > 0)
    }
}