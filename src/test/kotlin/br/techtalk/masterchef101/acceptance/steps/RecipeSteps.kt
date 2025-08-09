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
    private lateinit var currentRecipe: Recipe
    private var createdRecipe: Recipe? = null

    @Given("que estou a criar uma receita")
    fun `i am creating a recipe`() {
        currentRecipe = Recipe()
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

    @When("envio os dados da receita")
    fun `send the recipe data`() {
        createdRecipe = recipeService.save(currentRecipe)
    }

    @Then("a receita deve ser criada")
    fun `the recipe must be created`() {
        assertNotNull(createdRecipe)
        assertEquals(currentRecipe, createdRecipe)
    }

    @Then("a classificacao deve ser salva")
    fun `the classification must be saved`(){
        assertNotNull(createdRecipe)
        assertTrue(createdRecipe?.stars!! > 0)
    }
}