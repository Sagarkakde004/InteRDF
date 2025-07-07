# 🍽️ Catering Management System

A comprehensive full-stack web application for managing catering business operations. Built with Spring Boot backend, React frontend, and PostgreSQL database, designed to run locally with desktop-like experience.

## 📋 Features

### 🔐 Authentication
- Simple admin login system
- JWT-based authentication
- Session management

### 📦 Order Management
- **Full Catering**: Complete service including cook, waiter, service boys, utensils, water cans, tables, transport
- **Half Catering**: Custom items chosen by user
- Order status tracking: Pending, In Progress, Completed, Cancelled
- Payment tracking: Pending, Advance Paid, Fully Paid

### 👥 Employee Management
- Employee types: Cook, Bai, Waiter, Driver, Display Table Boy, Service Boy
- Track orders served per employee per day
- Calculate salary/payment based on orders served
- Employee search and filtering

### 📊 Inventory Management
- Track utensils, display tables, water cans, food items
- Assign materials to orders
- Monitor stock levels and usage
- Low stock notifications

### 🏢 Customer & Client Management
- One-time customers and permanent clients
- Payment tracking and history
- Customer type filtering
- Contact management

### ✅ Task Tracker
- Create tasks per order
- Task status: To-do, In Progress, Done, Deleted
- Assign tasks to employees
- Priority levels and due dates

### 📈 Reports Module
- Employee-wise reports: orders completed, payment due
- Order-wise reports: resource summary, total cost
- Monthly reports and analytics
- Export to PDF/CSV (planned)

## 🛠️ Technology Stack

- **Backend**: Java 17, Spring Boot 3, Hibernate JPA, Spring Security
- **Frontend**: React.js 18, Bootstrap 5, Axios, React Router
- **Database**: PostgreSQL 13+
- **Build Tool**: Maven
- **Server**: Embedded Tomcat

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- PostgreSQL 13 or higher
- Maven 3.6+ (optional, wrapper included)

### Database Setup
1. Install PostgreSQL and create database:
```sql
CREATE DATABASE catering_db;
CREATE USER catering_user WITH PASSWORD 'catering_pass';
GRANT ALL PRIVILEGES ON DATABASE catering_db TO catering_user;
```

### Installation & Running

#### Option 1: Double-Click Start (Recommended)
1. Download and extract the application
2. **Windows**: Double-click `start-catering-app.bat`
3. **Mac/Linux**: Run `./start-catering-app.sh`
4. Browser will open automatically at `http://localhost:8080`

#### Option 2: Manual Start
1. Clone the repository
2. Build the application:
```bash
mvn clean package
```
3. Run the application:
```bash
java -jar target/catering-management-1.0.0.jar
```
4. Open browser to `http://localhost:8080`

### Default Login
- **Username**: `admin`
- **Password**: `admin123`

## 📁 Project Structure

```
catering-management/
├── src/main/java/com/catering/
│   ├── entity/          # JPA entities
│   ├── repository/      # Data repositories
│   ├── service/         # Business logic
│   ├── controller/      # REST controllers
│   └── config/          # Configuration classes
├── src/main/resources/
│   ├── application.properties
│   ├── schema.sql       # Database schema
│   └── data.sql         # Sample data
├── frontend/
│   ├── src/
│   │   ├── components/  # React components
│   │   ├── services/    # API services
│   │   └── utils/       # Utilities
│   └── public/
├── start-catering-app.bat    # Windows startup script
├── start-catering-app.sh     # Unix startup script
└── README.md
```

## 🔧 Configuration

### Database Configuration
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/catering_db
spring.datasource.username=catering_user
spring.datasource.password=catering_pass
```

### Server Configuration
```properties
server.port=8080
app.desktop.auto-open-browser=true
```

## 📱 Usage Guide

### Dashboard
- Overview of orders, employees, and inventory
- Quick stats and recent activities
- Navigation to all modules

### Managing Orders
1. **Create Order**: Choose Full/Half catering, set details
2. **Assign Employees**: Select required staff for the order
3. **Assign Inventory**: Allocate utensils and materials
4. **Track Progress**: Update order status and payments

### Employee Management
1. **Add Employee**: Enter details and employee type
2. **Set Rates**: Configure daily rate and per-order rate
3. **Track Performance**: View orders served and payments

### Inventory Tracking
1. **Add Items**: Create inventory items with categories
2. **Monitor Stock**: Track current and minimum stock levels
3. **Order Assignment**: Assign items to specific orders

## 🔒 Security Features

- JWT token-based authentication
- Password encryption with BCrypt
- CORS configuration for frontend integration
- Input validation and sanitization

## 🎨 UI Features

- Responsive Bootstrap design
- Modern gradient styling
- Toast notifications for user feedback
- Loading states and error handling
- Print-friendly layouts

## 📊 Business Logic

### Payment Calculations
- Automatic remaining amount calculation
- Employee payment tracking per order
- Payment status management

### Inventory Management
- Stock level monitoring
- Order-based allocation and return tracking
- Low stock alerts

### Task Management
- Priority-based task organization
- Employee assignment and tracking
- Due date monitoring

## 🚀 Deployment

### Local Deployment
The application is designed to run locally as a desktop application:
1. Package with `mvn clean package`
2. Distribute the JAR file with startup scripts
3. Users can run by double-clicking the startup script

### Production Deployment
For production deployment:
1. Configure production database
2. Update `application-prod.properties`
3. Build with production profile: `mvn clean package -Pprod`

## 🤝 Contributing

1. Fork the repository
2. Create feature branch: `git checkout -b feature/new-feature`
3. Commit changes: `git commit -am 'Add new feature'`
4. Push to branch: `git push origin feature/new-feature`
5. Submit pull request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆘 Support

For support and questions:
- Check the troubleshooting section below
- Create an issue on GitHub
- Contact the development team

## 🔧 Troubleshooting

### Common Issues

**Application won't start**
- Ensure Java 17+ is installed
- Check PostgreSQL is running
- Verify database credentials

**Browser doesn't open automatically**
- Manually navigate to `http://localhost:8080`
- Check if port 8080 is available

**Database connection errors**
- Verify PostgreSQL service is running
- Check database name and credentials
- Ensure user has proper permissions

**Build failures**
- Ensure Maven is properly configured
- Check internet connection for dependencies
- Verify Java version compatibility

## 📈 Future Enhancements

- [ ] Mobile responsive improvements
- [ ] Advanced reporting with charts
- [ ] Email notifications
- [ ] Multi-user roles and permissions
- [ ] Integration with accounting software
- [ ] Mobile app development
- [ ] Cloud deployment options

---

**Built with ❤️ for the catering industry**

