package com.example.saba.sampleKotlin.mvi.anotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class LayoutResourceId(
        val value: Int
)