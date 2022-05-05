1. Run Docker:
>docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=r00t -d mysql:8

2. APIs

GET: Find sll processes
>http://localhost:8080/process/

POST: Add process
>http://localhost:8080/process/HIGH
>
>http://localhost:8080/process/MEDIUM
>
>http://localhost:8080/process/LOW

GET: Sort processes by creation time
>http://localhost:8080/process/time
>
GET: Sort processes by priority
>http://localhost:8080/process/priority
>
GET: Sort processes by PID
>http://localhost:8080/process/pid
>
@DELETE: Kill a process by PID
>http://localhost:8080/process/{pid}
>
@DELETE: Kill group of processes with a specific priority
>http://localhost:8080/process/{priority}
>
@DELETE: Kill all processes
>http://localhost:8080/process/