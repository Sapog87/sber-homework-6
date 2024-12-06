package org.sber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {

    @Test
    void givenOneElementArray_whenHasNext_thenReturnTrue() {
        //given
        Iterator<Integer> itr = new ArrayIterator<>(new Integer[]{1});
        //when
        boolean result = itr.hasNext();
        //then
        Assertions.assertTrue(result);
    }

    @Test
    void givenEmptyArray_whenHasNext_thenReturnFalse() {
        //given
        Iterator<Integer> itr = new ArrayIterator<>(new Integer[]{});
        //when
        boolean result = itr.hasNext();
        //then
        assertFalse(result);
    }

    @Test
    void givenEmptyArray_whenRetrieveNext_thenThrowsException() {
        //given
        Iterator<Integer> itr = new ArrayIterator<>(new Integer[]{});
        //when
        //then
        assertThrowsExactly(NoSuchElementException.class, itr::next);
    }

    @Test
    void givenOneElementArray_whenRetrieveNext_thenOk() {
        //given
        Iterator<Integer> itr = new ArrayIterator<>(new Integer[]{1});
        //when
        Integer next = itr.next();
        //then
        assertEquals(next, 1);
        assertFalse(itr.hasNext());
    }

    @Test
    void givenMultiElementArray_whenRetrieveNext_thenOk() {
        //given
        Iterator<Integer> itr = new ArrayIterator<>(new Integer[]{2, 1});
        //when
        Integer next = itr.next();
        //then
        assertEquals(next, 2);
        assertTrue(itr.hasNext());
    }
}