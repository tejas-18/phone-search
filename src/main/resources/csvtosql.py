import mysql.connector
import csv

# MySQL database configuration
db_config = {
    'host': 'localhost',
    'user': '',
    'password': '',
    'database': ''
}

# Path to your CSV file
csv_file = 

# Connect to MySQL database
conn = mysql.connector.connect(**db_config)
cursor = conn.cursor()

# Open CSV file and read data
with open(csv_file, 'r') as f:
    reader = csv.reader(f)
    next(reader)  # Skip header row
    for row in reader:
        # Replace empty values with None
        row = [None if value == '' else value for value in row]
        # Insert data into database
        cursor.execute("""
            INSERT INTO phones (brand_name, model, price, avg_rating, is_5G, processor_brand, num_cores, processor_speed,
            battery_capacity, fast_charging_available, fast_charging, ram_capacity, internal_memory, screen_size, refresh_rate,
            num_rear_cameras, os, primary_camera_rear, primary_camera_front, extended_memory_available, resolution_height, resolution_width)
            VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        """, row)

# Commit changes and close connection
conn.commit()
conn.close()

print("Data inserted successfully!")
