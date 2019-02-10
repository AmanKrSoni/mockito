package com.cvt.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MathCalMultiTimesArgumentTest {

    @Mock
    MathCal mathCal;


    @Captor  //for First Argument
    ArgumentCaptor<Integer> first;

    @Captor  // for 2nd
    ArgumentCaptor<Integer> second;

    @Captor  // for 3rd
    ArgumentCaptor<Integer> third;

    @Test
    public void add() throws Exception {
        //Argumnet Passed
        mathCal.Add(2,3,5);
        mathCal.Add(23,45,67);

        Mockito.verify(mathCal,Mockito.times(2))
                .Add(first.capture(),second.capture(),third.capture());
        System.out.println("Argument Passed =>");
        System.out.println("First Args :"+first.getAllValues());
        System.out.println("Sec Args :"+second.getAllValues());
        System.out.println("Third Args "+third.getAllValues());

    }

}