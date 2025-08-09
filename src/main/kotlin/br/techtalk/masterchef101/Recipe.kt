package br.techtalk.masterchef101

import jakarta.persistence.*
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Null

@Entity
@Table(name = "recipes")
data class Recipe(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank(message = "Name is needed")
    @Column(nullable = false)
    var name: String? = null,

    @field:NotBlank(message = "Description is needed")
    var description: String? = null,

    @field:Max(5, message = "5 is max")
    var stars: Int? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Recipe

        if (name != other.name) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (description?.hashCode() ?: 0)
        return result
    }
}
