package com.myorg

import software.amazon.awscdk.core.App

object CdkApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val app = App()
        CdkStack(app, "CdkStack")
        app.synth()
    }
}