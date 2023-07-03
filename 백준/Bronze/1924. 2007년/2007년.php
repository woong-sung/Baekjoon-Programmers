<?php
fscanf(STDIN, "%d %d", $m, $d);
$days = array(31, 28, 31,30,31,30,31,31,30,31,30, 31);
$week = array('SUN','MON','TUE','WED','THU','FRI','SAT',);
$day = $d;
for ($i = 0; $i < $m-1; $i++) {
    $day += $days[$i];
}
$day %= 7;
printf($week[$day]);
?>