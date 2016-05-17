select *from (select * from NOTICE ORDER BY regdate desc) where rownum between 1 and 10 ;
select * from NOTICE where CODE = '2';

Insert into NOTICE(CODE, TITLE, WRITER,REGDATE,HIT) values(?,'title','¿Ã¡¯»£','c',TIMESTAMP,0)

select MAX(TO_NUMBER(code)+1) CODE from NOTICE; 

select * from NOTICE

Delete NOTICE where CODE =1;

select * from notice;
select * from "COMMENT";

select A.MEMBER, A.TITLE, A.WRITER, A.CONTENT, A.REGDATE B.AGE
FROM NOTICE A , MEMBER B
WHERE A.WRITER=B.NAME;



CREATE VIEW NOTICE_VIEW AS SELECT N.CODE, N.TITLE, N.WRITER, N.CONTENT, N.REGDATE, N.HIT, M.NAME WRITER_NAME, COUNT(C.CODE) CMT_CNT FROM
MEMBER M
RIGHT OUTER JOIN NOTICE N ON M.MID = N.WRITER
LEFT OUTER JOIN "COMMENT" C ON N.CODE = C.NOTICE_CODE
GROUP BY N.CODE, N.TITLE, N.WRITER, N.CONTENT, N.REGDATE, N.HIT, M.NAME 
ORDER BY N.REGDATE DESC;

DROP VIEW NOTICE_VIEW;


select * from (select ROWNUM RNUM ,CODE, TITLE, WRITER, "CONTENT",REGDATE, HIT, WRITER_NAME, CMT_CNT 
from NOTICE_VIEW ORDER BY REGDATE DESC) A
where A.RNUM between 11 and 20;

select * from comment;
;
SELECT * FROM( select * from NOTICE_VIEW where  )where num between 11 AND 20;


select * from notice_view where rownum = 4; 

select * from(select rownum NUM,  NOTICE_VIEW. * from NOTICE_view where field like %% where num between 1 and 10;

select * from(select rownum NUM,  NOTICE_VIEW. * from NOTICE_view) where num= 3+2;
