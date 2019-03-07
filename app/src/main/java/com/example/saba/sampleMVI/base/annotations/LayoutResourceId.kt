package com.example.saba.sampleMVI.base.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class LayoutResourceId(val value: Int)