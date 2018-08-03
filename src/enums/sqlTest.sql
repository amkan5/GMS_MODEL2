--페이지 수를 구하는 쿼리?? 

SELECT COUNT(*)
FROM MEMBER
;

--역정렬
SELECT t.*
FROM (SELECT ROWNUM seq, m.*
FROM member m 
order by seq desc) t
where t.seq between 1 and 5 ;


SELECT 
B.*
FROM 
(SELECT
	ROWNUM RNUM,
	A.*
	FROM (SELECT *
          FROM MEMBER)A)B
    WHERE B.RNUM BETWEEN 1 AND 5;
    
    
 -- 이렇게했던거보고 . 페이지 2라고 하면 저게떠야해. 
 -- ㅇ_ㅇ? 첨에 돌렸을때. 


 -- 페이지 수를 고치는 쿼리
 -- ROWNUM을 구한 뒤 -> 최근에 등록된 회원이 60번.... 
 -- 페이지랑 회원의 ID로 만 보여주는 쿼리 
 -- (웨어조건에 페이지번호를 2룰 누르면 
 -- where exist 
  -- 쿼리까지는 짰어... ㅎ




