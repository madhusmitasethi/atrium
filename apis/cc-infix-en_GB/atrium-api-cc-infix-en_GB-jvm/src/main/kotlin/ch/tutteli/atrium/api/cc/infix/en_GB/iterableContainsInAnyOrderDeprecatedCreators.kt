@file:JvmMultifileClass
@file:JvmName("IterableContainsInAnyOrderCreatorsKt")
package ch.tutteli.atrium.api.cc.infix.en_GB

import ch.tutteli.atrium.creating.Assert
import ch.tutteli.atrium.creating.AssertionPlant
import ch.tutteli.atrium.domain.creating.iterable.contains.IterableContains
import ch.tutteli.atrium.domain.creating.iterable.contains.searchbehaviours.InAnyOrderSearchBehaviour

@JvmName("nullableValueDeprecated")
@Deprecated("use `value` instead; will be removed with 1.0.0", ReplaceWith("this value expectedOrNull"))
infix fun <E : Any?, T : Iterable<E>> IterableContains.CheckerOption<E, T, InAnyOrderSearchBehaviour>.nullableValue(expectedOrNull: E): AssertionPlant<T>
    = this value expectedOrNull

@JvmName("nullableEntryDeprecated")
@Deprecated("use `entry` instead; will be removed with 1.0.0", ReplaceWith("this entry assertionCreatorOrNull"))
infix fun <E : Any, T : Iterable<E?>> IterableContains.CheckerOption<E?, T, InAnyOrderSearchBehaviour>.nullableEntry(assertionCreatorOrNull: (Assert<E>.() -> Unit)?): AssertionPlant<T>
    = this entry assertionCreatorOrNull