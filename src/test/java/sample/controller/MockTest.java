package sample.controller;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import static org.mockito.Mockito.*;
/**
 * Created by takahashi on 2016/03/10.
 */
public class MockTest {

    @Test
    public void testMock1() throws Exception {
        List mockList = mock(List.class); // Listクラスをモック化

        when(mockList.get(anyInt())).thenReturn("first"); // List#get()メソッドがInteger型の引数で呼び出された場合、常に"first"を返す。

        mockList.clear();
        assertThat(mockList.get(2), is("first"));
        assertThat(mockList.get(2), is("first"));

        verify(mockList, times(2)).get(2); //get()が引数2で一回呼ばれたことを検証
        verify(mockList).clear(); //clear()が１回呼ばれたことを検証
    }
}
