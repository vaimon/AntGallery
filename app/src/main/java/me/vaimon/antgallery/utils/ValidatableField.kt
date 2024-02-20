package me.vaimon.antgallery.utils

abstract class EditableField<T>(
    initialValue: T? = null
){
    protected var _value: T? = initialValue
    val value: T?
        get() = _value

    abstract val isValid: Boolean
}

abstract class ValidatableField<T>(
    initialValue: T? = null
) : EditableField<T>(initialValue) {
    override val isValid: Boolean
        get() = validate(_value)

    fun validateAndSet(value: T?): Boolean{
        return validate(value).also {
            _value = value
        }
    }
    protected abstract fun validate(input: T?): Boolean
}

abstract class ComparingValidatableField<T>(
    initialValue: T?,
) : EditableField<T>(initialValue){
    private var lastComparingValue: T? = null
    fun compareAndSet(input: T?, comparingValue: T?): Boolean{
        return input == comparingValue.also {
            lastComparingValue = it
            _value = input
        }
    }
    override val isValid: Boolean
        get() = _value == lastComparingValue
}