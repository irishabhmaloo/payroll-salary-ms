CREATE TABLE IF NOT EXISTS `salary` (
    `salary_id` INT AUTO_INCREMENT PRIMARY KEY,
    `emp_id` INT NOT NULL,
    `date_from` DATE NOT NULL,
    `date_to` DATE NOT NULL,
    `basic_amt` INT NOT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(30) NOT NULL,
    `updated_at` DATE DEFAULT NULL,
    `updated_by` VARCHAR(30) DEFAULT NULL
);