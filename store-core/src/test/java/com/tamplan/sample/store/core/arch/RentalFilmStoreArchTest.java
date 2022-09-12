package com.tamplan.sample.store.core.arch;


import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.tamplan.sample.store", importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeJars.class
})
public class RentalFilmStoreArchTest {

    @ArchTest
    public static final ArchRule domainShouldNotHaveAnyDependenciesOtherThanJdkAndItself = ArchRuleDefinition
            .classes().that().resideInAPackage("com.tamplan.sample.store.core.domain..")
            .should().onlyDependOnClassesThat().resideInAnyPackage(
                    "com.tamplan.sample.store.core.domain..",
                    "com.tamplan.sample.store.core.commons..",
                    "com.tamplan.sample.store.lib..",
                    "com.tamplan.sample.store.core.repository..",
                    "org.slf4j..",
                    "java..");
}
