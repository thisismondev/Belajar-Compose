package id.co.mondo.jetheroes.data

import id.co.mondo.jetheroes.model.Hero
import id.co.mondo.jetheroes.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero>{
        return HeroesData.heroes
    }
}