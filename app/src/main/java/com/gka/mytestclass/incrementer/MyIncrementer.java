package com.gka.mytestclass.incrementer;

/**
 * @author Khasan Ganikhodjaev
 */

public class MyIncrementer implements Incrementer {

    private int number;
    private int maximumValue = Integer.MAX_VALUE;


    /**
     * Возвращает текущее число.
     * Значение при инициализации равно 0.
     */
    @Override
    public int getNumber() {
        return number;
    }

    /**
     * Увеличивает число на 1, после вызывает метод checkAndCorrectNumber()
     */
    @Override
    public void incrementNumber() {
        number++;
        checkAndCorrectNumber();
    }

    /**
     * Устанавливает максимум (maximumValue) для числа (number)
     * При попытке установить отрицательное значение выдает RuntimeException
     */
    @Override
    public void setMaximumValue(int maximumValue) {
        if (maximumValue < 0)
            throw new RuntimeException("Maximum number value is negative");

        this.maximumValue = maximumValue;

        checkAndCorrectNumber();
    }

    /**
     * Проверяет и корректирует текущее значение числа.
     * Метод вызывается после увелечения числа на единицу incrementNumber() и после установки нового максимального значения setMaximumValue()
     * Если текущее число (number) было больше установленного максимума (maximumValue), то оно (number) приравняется 0.
     * Если текущее число (number) меньше 0, то оно (number) приравняется 0.
     * Текущее число (number) может принять отрицательно значение, если вызвать метод incrementNumber() когда текущее значение числа (number) равна максимальному значению Integer (Integer.MAX_VALUE)
     */
    private void checkAndCorrectNumber() {
        if (number > maximumValue) number = 0;
        if (number < 0) number = 0;
    }
}
