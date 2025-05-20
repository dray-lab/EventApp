-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2025 at 06:14 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `event_name` varchar(200) NOT NULL,
  `event_type` varchar(100) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `event_type` varchar(100) NOT NULL,
  `event_name` varchar(200) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `venue` varchar(255) NOT NULL,
  `packages` text DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `actions` varchar(100) NOT NULL,
  `details` text DEFAULT NULL,
  `timestamp` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `u_id`, `actions`, `details`, `timestamp`) VALUES
(1, 10, 'Login', 'User logged in successfully', '2025-05-20 10:47:41'),
(2, 10, 'Password Change', 'Password changed successfully', '2025-05-20 11:08:23'),
(3, 10, 'Login', 'User logged in successfully', '2025-05-20 11:08:44'),
(4, 3, 'Password Change', 'Password changed successfully', '2025-05-20 11:13:06'),
(5, 3, 'Login', 'User logged in successfully', '2025-05-20 11:13:27');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_registeruser`
--

CREATE TABLE `tbl_registeruser` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(100) NOT NULL,
  `u_lname` varchar(100) NOT NULL,
  `u_email` varchar(150) NOT NULL,
  `u_username` varchar(100) NOT NULL,
  `u_password` varchar(255) NOT NULL,
  `u_type` enum('Admin','User') NOT NULL,
  `u_status` enum('Pending','Active','Inactive') DEFAULT 'Pending',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_registeruser`
--

INSERT INTO `tbl_registeruser` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_type`, `u_status`, `created_at`, `updated_at`) VALUES
(1, 'Mike', 'Bus', 'mike3@gmail.com', 'busta', 'N6CjSaZSWDeo3TPmC9HUnJog8Vg7SxGVGtuJzpkEpnA=', 'Admin', 'Active', '2025-03-18 15:41:03', '2025-03-22 15:37:30'),
(2, 'Diovely', 'Campo', 'diovely@gmail.com', 'dyubli', 'N6CjSaZSWDeo3TPmC9HUnJog8Vg7SxGVGtuJzpkEpnA=', 'User', 'Active', '2025-03-22 15:24:08', '2025-03-22 15:37:30'),
(3, 'Dray', 'Misa', 'misadranreb4@gmail.com', 'Dray', '$2a$10$qnFeUGTxrfTe68W/igjmzuQbE6nbuHxBCX2Lztjm0N2qhWbkuYmQW', 'Admin', 'Active', '2025-05-05 02:22:58', '2025-05-20 16:13:06'),
(4, 'Kris Jaylon', 'Mantillas', 'jaylon@gmail.com', 'jaylon', 'x3Xnt1ft5jDNCqERO9ECZhqziCnKUqZCKreChi8mhkY=', 'User', 'Active', '2025-05-06 09:29:08', '2025-05-06 09:29:45'),
(7, 'Dranreb', 'Misa', 'misadray1@gmail.com', 'Dranreb', '0tLCWgtLLuIq00rr/ysNBLzxA+HvbcVCScJVjXwFKfE=', 'User', 'Active', '2025-05-18 08:26:23', '2025-05-20 15:30:06'),
(9, 'Draniel', 'Misa', 'misadran@gmail.com', 'Draniel', 'ovwnnU15vOKI/E5ty+0U8/2rJXxg1HsKdD+OBs4Fcqs=', 'Admin', 'Active', '2025-05-18 13:08:08', '2025-05-20 16:09:29'),
(10, 'Lance', 'Alberto', 'misadray3@gmail.com', 'Lance', '$2a$10$2dIy2R0v9VIR8/Fd83yneOwlRe118OhWgDI/Ksn7PmO46O0OJAeaq', 'User', 'Active', '2025-05-20 15:30:44', '2025-05-20 16:08:23');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `tbl_registeruser`
--
ALTER TABLE `tbl_registeruser`
  ADD PRIMARY KEY (`u_id`),
  ADD UNIQUE KEY `u_email` (`u_email`),
  ADD UNIQUE KEY `u_username` (`u_username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_registeruser`
--
ALTER TABLE `tbl_registeruser`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_registeruser` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `events_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_registeruser` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_registeruser` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
