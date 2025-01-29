-- 코드를 작성해주세요
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2) = 0 # 10 과 & 비트연산 했을때 0 이면서 => 2번형질 미보유
  AND ((GENOTYPE & 1) > 0 OR (GENOTYPE & 4) > 0) # 1번형질 ,3번형질 미보유