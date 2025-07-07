#!/bin/bash
# Catering Management System Startup Script for Unix/Linux/Mac
# This script starts the application and opens it in the default browser

echo "========================================"
echo "  Catering Management System"
echo "  Starting Application..."
echo "========================================"

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "ERROR: Java is not installed or not in PATH"
    echo "Please install Java 17 or higher and try again"
    exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}' | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 17 ]; then
    echo "ERROR: Java 17 or higher is required"
    echo "Current Java version: $JAVA_VERSION"
    exit 1
fi

# Check if PostgreSQL is running (optional check)
echo "Checking PostgreSQL connection..."
if command -v pg_isready &> /dev/null; then
    if ! pg_isready -h localhost -p 5432 &> /dev/null; then
        echo "WARNING: PostgreSQL might not be running on localhost:5432"
        echo "Please ensure PostgreSQL is installed and running"
        echo "Database: catering_db, User: catering_user"
        echo ""
        echo "You can continue if you have PostgreSQL configured differently"
        echo "Press Enter to continue or Ctrl+C to cancel and setup PostgreSQL first"
        read -r
    fi
else
    echo "PostgreSQL client tools not found. Assuming PostgreSQL is configured."
fi

# Create necessary directories
mkdir -p reports temp logs

# Set Java options for better desktop integration
export JAVA_OPTS="-Djava.awt.headless=false -Xmx1024m -Xms512m"

echo "Starting Spring Boot application..."
echo "Please wait while the application starts up..."
echo "The browser will open automatically once ready."
echo ""

# Start the Spring Boot application
java $JAVA_OPTS -jar target/catering-management-1.0.0.jar

# If we reach here, the application has stopped
echo ""
echo "Application has stopped."
read -p "Press Enter to exit..."

