#코딩개념 잡는 자바 코딩 문제집

##1장 문자열과 수, 수학

###001. 문재 개수 세기 : 주어진 문자열에서 문자 개수를 세기

###002. 반복되지 않는 첫번쨰 문자 찾기

###003. 글자와 단어 뒤집기

###004. 숫자만 포함하는 문자열인지 검사
Character.isDigit()이나 String matches()메서드를 활용한다.
외부 라이브러리 지원을 받으로면 아마치 커먼즈 랭의 StringUtils.isNumeric()를 사용한다.
* 자바 8 함수형 스타일과 정규식 기반 해법은 대게 느리므로 속도가 중요하다면 Character.isDigit()를 사용하는것이 좋다

###005. 모음과 자음 세기

###006. 문자 빈도수 세기 
Chapter01/P06/Main.java
* 주어진 문자를 지워서 줄어든 문자수를 센다 .
* 문자열을 for문으로 순회해서 count++
* 함수형의 filter 나 reduce를 사용
* 외부 라이브러리를 사용한다면  
  * 아파치 커먼즈 랭의 StringUtils.countMatches()
  * 스프링 프레임워크의 StringUtils.countOccurrencesOf()
  * 구아바의 CharMatcher.is().countIn()

###007. 문자열을 int, long, float, double로 변환

* 외부 라이브러리를 사용한다면
  * 아마치 커먼즈 빈유틸즈(BeanUtils)의 IntegerConverter, LongConverter, FloatConverter, DoubleConverter를 사용한다.

###P008 문자열에서 여백제거
String.replaceAll("\\s","") 사용 한다.
\\s는 \t \n \r 처럼 보이지 않는 여백을 포함해 모든 여백을 제거 한다

JDK 11부터는 String.isBlack()를 사용해 문자열이 비었는지 혹은 여백코드포인트(code point)만 포함하는지 검사할수 있다.

외부 라이브러리 지원을 받으려면
아파치 커먼즈 랭의 StringUtils.deleteWhitspace()
스프링 프레임워크 StringUtils.trimAllWhiteSpace()


