package com.tanmay.api

import com.tanmay.api.models.request.SignupRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.random.Random
import com.tanmay.api.models.entities.UserCreds as UserCreds
import com.tanmay.api.ConduitClient


class ConduitClientTest {

    private val conduitClient = ConduitClient()

    @Test
    fun `Get articles`(){

        runBlocking {
            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Get articles by author`(){

        runBlocking {
            val articles = conduitClient.api.getArticles(author="444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Get articles by tags`(){

        runBlocking {
            val articles = conduitClient.api.getArticles(tag = "dragons")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Post users - create user`(){

        val userCreds= UserCreds(
            email="testemail${Random.nextInt(999,9999)}@test.com",
            password="${Random.nextInt(10000000,100000000)}",
            username="rand_user${Random.nextInt(99,9999)}"
        )

        val signupRequest = SignupRequest(userCreds)

        runBlocking {
            val resp = conduitClient.api.signupUser(signupRequest)
            assertEquals(userCreds.username,resp.body()?.user?.username)
        }
    }
}