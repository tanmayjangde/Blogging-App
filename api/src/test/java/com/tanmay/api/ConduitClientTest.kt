package com.tanmay.api

import com.tanmay.api.models.request.SignupRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.random.Random
import com.tanmay.api.models.entities.UserCreds as UserCreds
import com.tanmay.api.ConduitClient
import com.tanmay.api.models.entities.SignupData


class ConduitClientTest {

    private val conduitClient = ConduitClient

    @Test
    fun `Get articles`(){

        runBlocking {
            val articles = conduitClient.publicApi.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Get articles by author`(){

        runBlocking {
            val articles = conduitClient.publicApi.getArticles(author="444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Get articles by tags`(){

        runBlocking {
            val articles = conduitClient.publicApi.getArticles(tag = "dragons")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Post users - create user`(){

        val signupData = SignupData("useerr77","hfjk@gmail.com","hkalkjaf")

        val signupRequest = SignupRequest(signupData)

        runBlocking {
            val resp = conduitClient.publicApi.signupUser(signupRequest)
            assertEquals(signupData.username,resp.body()?.user?.username)
        }
    }
}