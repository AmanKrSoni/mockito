package com.cvt.hamcrest;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;


// use Mathers   not CoreMatcher
public class HamcrestMatcher {

    @Test
    public void test1() throws Exception {
        List<Integer> scores= Arrays.asList(99,100,101,105);
        //score has size 4

        assertThat(scores,hasSize(4));
        assertThat(scores,hasItems(99,105));

        //every items > 90
        assertThat(scores,everyItem(greaterThan(90)));
        assertThat(scores,everyItem(greaterThanOrEqualTo(99)));

        //String
        assertThat("",isEmptyString());
        assertThat(null,isEmptyOrNullString());

        //Array
        Integer[] marks={1,2,3};

        assertThat(marks,arrayWithSize(3));
        assertThat(marks,arrayContainingInAnyOrder(1,3,2));

    }
}
