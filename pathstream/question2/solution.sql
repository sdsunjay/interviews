select u.id, i.id from users u inner join orders o on u.id = o.userid inner join items i on o.itemid = i.id group by o.userid


GROUP_CONCAT(o.id SEPARATOR ',') WITHIN GROUP (ORDER BY o.id ASC)



select o.userid o.itemid from orders o inner join items i on i.id = o.itemid group by o.userid having(count(o.itemid) > 0) order by count(o.itemid) DESC

select o.userid, o.itemid from orders o group by o.userid having(count(o.itemid) > 0) order by count(o.itemid) DESC

select distinct userid,
SUBSTRING (  (SELECT ',' + o.itemid as [text()] from orders o where o.userid = o1.userid) order by o.itemid for XML PATH('')), 2, 1000) [orders]
from orders o1
order by count(o1.itemid) DESC;


SELECT DISTINCT ST2.SubjectID,
    SUBSTRING(
        (
            SELECT ','+ST1.StudentName  AS [text()]
            FROM dbo.Students ST1
            WHERE ST1.SubjectID = ST2.SubjectID
            ORDER BY ST1.SubjectID
            FOR XML PATH ('')
        ), 2, 1000) [Students]
FROM dbo.Students ST2
