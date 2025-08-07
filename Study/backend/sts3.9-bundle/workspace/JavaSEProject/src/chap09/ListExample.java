/*------------------------------------------------------------------------------
 * Name : ListExample
 * DESC : 
 * VER  : 1.0
 * PROJ : VCC SE Path
 * Copyright 2006 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   변        경        사        항
 *------------------------------------------------------------------------------
 *     DATE      AUTHOR                       DESCRIPTION
 *-------------  --------  ----------------------------------------------------- 
 * 2006. 8. 4.  기술대학원  ver1.0 작성
 *----------------------------------------------------------------------------*/
package chap09;

import java.util.*;

public class ListExample {

    public static void main( String[] args ) {

        // 순서 유지 한다.
        // 데이터 추가 가능하다.
        List list = new ArrayList(); //부모 list = new 자식();
        ArrayList list2 = new ArrayList(); //일반적
        //add(Object)
        list.add( "one" );
        list.add( "second" );
        list.add( "3rd" );
        list.add( new Integer(4) );
        list.add( new Float(5.0F) );
        list.add( "second" );
        list.add( new Integer(4) );
        System.out.println( list );

        //for loop
//        for(int i=0; i<list.size(); i++) {
//        	//get(index) 꺼내기 Object -> String으로 casting
//        	String value = (String)list.get(i);
//        	System.out.println(value);
//        }
        

        list.remove( "second" );
        list.remove( new Float(5.0F) );
        System.out.println( list );

        //Generics Java5
        List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add(new String("Collection"));
        strList.add("Hello");
        
        for (String value : strList) {
			System.out.println(value);
		}
    }
}
