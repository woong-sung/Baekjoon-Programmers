# -- 코드를 작성해주세요
SELECT
    id,
    email,
    first_name,
    last_name
FROM developers
WHERE
    skill_code & (
        SELECT SUM(code)
        FROM SKILLCODES
        WHERE NAME IN ("Python", "C#")
    ) != 0
ORDER BY ID