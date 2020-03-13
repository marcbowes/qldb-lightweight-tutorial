package com.myorg

import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.core.Stack
import software.amazon.awscdk.core.StackProps

class CdkStack @JvmOverloads constructor(scope: Construct?, id: String?, props: StackProps? = null) : Stack(scope, id, props)