@echo off
REM Catering Management System Startup Script for Windows
REM This script starts the application and opens it in the default browser

echo ========================================
echo   Catering Management System
echo   Starting Application...
echo ========================================

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 17 or higher and try again
    pause
    exit /b 1
)

REM Check if PostgreSQL is running (optional check)
echo Checking PostgreSQL connection...
pg_isready -h localhost -p 5432 >nul 2>&1
if %errorlevel% neq 0 (
    echo WARNING: PostgreSQL might not be running on localhost:5432
    echo Please ensure PostgreSQL is installed and running
    echo Database: catering_db, User: catering_user
    echo.
    echo You can continue if you have PostgreSQL configured differently
    echo or press Ctrl+C to cancel and setup PostgreSQL first
    pause
)

REM Create necessary directories
if not exist "reports" mkdir reports
if not exist "temp" mkdir temp
if not exist "logs" mkdir logs

REM Set Java options for better desktop integration
set JAVA_OPTS=-Djava.awt.headless=false -Xmx1024m -Xms512m

echo Starting Spring Boot application...
echo Please wait while the application starts up...
echo The browser will open automatically once ready.
echo.

REM Start the Spring Boot application
java %JAVA_OPTS% -jar target/catering-management-1.0.0.jar

REM If we reach here, the application has stopped
echo.
echo Application has stopped.
pause

