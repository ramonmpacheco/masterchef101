package br.techtalk.masterchef101.acceptance

import io.cucumber.junit.platform.engine.Constants.*
import org.junit.platform.suite.api.*

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters(
    ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.techtalk.masterchef101.acceptance.steps"),
    ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty"),
    ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:target/cucumber/index.html")
)
class RecipeCucumberRunner