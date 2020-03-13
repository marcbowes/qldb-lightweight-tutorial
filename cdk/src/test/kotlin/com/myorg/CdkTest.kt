package com.myorg

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import software.amazon.awscdk.core.App
import java.io.IOException

class CdkTest {
    @Test
    @Throws(IOException::class)
    fun testStack() {
        val app = App()
        val stack = CdkStack(app, "test")
        // synthesize the stack to a CloudFormation template and compare against
        // a checked-in JSON file.
        val actual = JSON.valueToTree<JsonNode>(app.synth().getStackArtifact(stack.artifactId).template)
        Assertions.assertEquals(ObjectMapper().createObjectNode(), actual)
    }

    companion object {
        private val JSON = ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true)
    }
}