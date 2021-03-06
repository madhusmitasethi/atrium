package ch.tutteli.atrium.domain.builders.utils

import ch.tutteli.kbox.glue

/**
 * Represents a parameter object used to express the arguments `T, vararg T`
 * and provides utility functions to transform them.
 */
interface VarArgHelper<out T> {
    /**
     * The first argument in the argument list `T, vararg T`
     */
    val expected: T

    /**
     * The second argument in the argument list `T, vararg T`
     */
    val otherExpected: Array<out T>

    /**
     * Creates an [ArgumentMapperBuilder] which allows to map [expected] and [otherExpected].
     */
    val mapArguments: ArgumentMapperBuilder<T> get() = ArgumentMapperBuilder(expected, otherExpected)

    /**
     * Returns the arguments as [List].
     */
    fun toList(): List<T> = expected glue otherExpected
}

/**
 * Transforms the given [iterable] to `Pair<T, Array<out T>>` with the intend that it can be easily used for a function
 * requiring `T, vararg T`
 *
 * @throws IllegalArgumentException in case the iterable is empty.
 */
inline fun <reified T> toVarArg(iterable: Iterable<T>): Pair<T, Array<out T>> {
    require(iterable.iterator().hasNext()) { "Iterable without elements are not allowed for this function." }
    return iterable.first() to iterable.drop(1).toTypedArray()
}
