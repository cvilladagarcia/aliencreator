@ECHO OFF
REM Autor: Gerson Samaniego
REM Formato esperado: build "DEPENDENCIAS" [maven goals]
REM SI [maven goals] == [vacio], [maven goals] = clean install
REM Ejemplo1: build												'hace "mvn clean install -P dev" a todos los modulos de DEPENDENCIAS
REM Ejemplo2: build "" clean							 		'hace "mvn clean" a todos los modulos de DEPENDENCIAS
REM Ejemplo3: build "mille-boots-common,mille-bots-whatsapp" clean install					'hace "mvn clean install" a common y whatsapp
REM Ejemplo4: build "" clean install -P prod			' Compila para producción

SET RUTA=%~dp0..\
SET COMANDO=mvn %2 %3 %4 %5 %6
SET LISTA=%~1

IF "%LISTA%"=="" SET LISTA=mille-bots-parent,mille-bots-common,mille-bots-whatsapp
IF "%2"=="" SET COMANDO=mvn clean install

cls

@ECHO ON
ECHO %COMANDO%
@ECHO OFF

FOR %%P IN (%LISTA%) DO (
	IF NOT "%%P"=="" (
		cd %RUTA%%%P
		ECHO %RUTA%%%P
		call %COMANDO%
	)
)
