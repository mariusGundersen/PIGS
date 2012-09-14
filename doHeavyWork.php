<?php
header('Content-Type: image/gif');

ob_implicit_flush(true);
ob_end_flush();

if(strtoupper(substr(PHP_OS, 0, 3)) === 'WIN'){
	$cmd = "pigs.bat";
}else{
	$cmd = "./pigs.sh";
}

passthru($cmd);