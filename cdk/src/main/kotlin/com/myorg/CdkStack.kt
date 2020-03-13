package com.myorg

import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.core.Stack
import software.amazon.awscdk.core.StackProps
import software.amazon.awscdk.services.kinesis.CfnStream
import software.amazon.awscdk.services.qldb.CfnLedger

class CdkStack(
    scope: Construct,
    id: String,
    props: StackProps? = null
) : Stack(scope, id, props) {
    init {
        CfnLedger.Builder.create(this, "sample-ledger") // actually becomes sampleledger
            .name("sample-ledger")
            .deletionProtection(false)
            .permissionsMode("ALLOW_ALL")
            .build()

        CfnStream.Builder.create(this, "sample-ledger-stream")
            .name("sample-ledger-stream")
            .shardCount(1)
            .build()
    }
}