<?php
header('Content-Type: image/gif');

ob_implicit_flush(true);
ob_end_flush();

passthru('pigs.bat');