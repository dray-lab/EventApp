-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2025 at 04:44 PM
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
  `user_name` varchar(100) NOT NULL,
  `event_name` varchar(100) NOT NULL,
  `event_type` varchar(50) NOT NULL,
  `amount` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`id`, `user_name`, `event_name`, `event_type`, `amount`) VALUES
(1, 'Jane Dela Cruz', 'Concert of Legends', 'Concert', 1500.00),
(2, 'Jane Dela Cruz', 'Theater Night Gala', 'Theater', 1200.00),
(3, 'Jane Dela Cruz', 'Beach Festival 2025', 'Festival', 1000.00),
(4, 'Jane Dela Cruz', 'New Year Countdown', 'Party', 1800.00);

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `event_type` varchar(50) DEFAULT NULL,
  `event_name` varchar(100) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `venue` varchar(100) DEFAULT NULL,
  `packages` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `event_type`, `event_name`, `amount`, `venue`, `packages`) VALUES
(1, 'Occasion', 'Birthday Party - Bronze', 15000.00, 'TBD', 'Up to 50 Attendees\r\nCatering Services\r\nCake\r\n'),
(2, 'Occasion', 'Birthday Party - Silver', 22000.00, 'Drayenz Hall', 'Full styling \nHost \nSound system Cake\nCatering for 50\nPhotographer'),
(3, 'Ocassions', 'Birthday Party - Gold', 45000.00, 'Drayenz Hall', 'Full styling \nSound system \nCake \nCatering for 75 \nHost \nPhotographer + Videographer'),
(4, 'Ocassions', 'Birthday Party - Premium', 100000.00, 'Drayenz Grand Venue', 'Full concept styling, LED stage, Video team, Photo booth, Catering 150 pax, Entertainment'),
(5, 'Occasion', 'Wedding Package', 70000.00, 'Grand Hotel Garden', 'Event coordination, Catering, Music, Decor, Host, Photography'),
(6, 'Occasion', 'Reunion Package', 50000.00, 'City Convention Hall', 'Event coordination, Catering, Sound System, Host, Games'),
(7, 'Entertainment', 'BINI Concert', 11000.00, 'MOA Arena', 'VIP Standing, Patron, Box A/B, Gen Ad - Seat Map'),
(8, 'Entertainment', 'BTS', 9500.00, 'MOA Arena', 'VIP Standing, Patron, Box A/B, Gen Ad - Seat Map'),
(9, 'Entertainment', 'Theater Show', 6000.00, 'Cultural Center', 'Main Stage Seating, Balcony, VIP Access'),
(10, 'Entertainment', 'Comedy Show', 3000.00, 'Live Club', 'Front Row, Regular Seat, Drinks and Snacks');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `actions` varchar(255) NOT NULL,
  `details` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `u_id`, `actions`, `details`, `timestamp`) VALUES
(1, 1, 'Create Event', 'Created a new event called Summer Beach Volleyball 2025.', '2025-05-05 02:57:41'),
(2, 2, 'Update Event', 'Updated the event details for Volleyball Tournament 2025.', '2025-05-05 02:57:41'),
(3, 1, 'Delete Event', 'Deleted event \"Beach Volleyball Showdown\".', '2025-05-05 02:57:41'),
(4, 3, 'Login', 'User logged in successfully', '2025-05-05 02:58:02'),
(5, 3, 'Login', 'User logged in successfully', '2025-05-05 03:02:18'),
(6, 3, 'Login', 'User logged in successfully', '2025-05-05 03:04:40'),
(7, 3, 'Login', 'User logged in successfully', '2025-05-05 03:51:46'),
(8, 3, 'Login', 'User logged in successfully', '2025-05-05 03:52:58'),
(9, 3, 'Login', 'User logged in successfully', '2025-05-05 03:55:35'),
(10, 3, 'Login', 'User logged in successfully', '2025-05-05 03:58:59'),
(11, 3, 'Login', 'User logged in successfully', '2025-05-05 04:01:23'),
(12, 3, 'Login', 'User logged in successfully', '2025-05-06 08:58:40'),
(13, 3, 'Login', 'User logged in successfully', '2025-05-06 09:00:21'),
(14, 3, 'Login', 'User logged in successfully', '2025-05-06 09:16:29'),
(15, 3, 'Login', 'User logged in successfully', '2025-05-06 09:18:12'),
(16, 3, 'Login', 'User logged in successfully', '2025-05-06 09:23:12'),
(17, 4, 'Login', 'User logged in successfully', '2025-05-06 09:29:49'),
(18, 4, 'Password Reset Request', 'User requested a password reset', '2025-05-06 09:34:33'),
(19, 4, 'Login', 'User logged in successfully', '2025-05-06 09:36:23'),
(20, 4, 'Login', 'User logged in successfully', '2025-05-06 09:42:41'),
(21, 4, 'Login', 'User logged in successfully', '2025-05-06 09:47:30'),
(22, 4, 'Login', 'User logged in successfully', '2025-05-06 09:57:00'),
(23, 4, 'Login', 'User logged in successfully', '2025-05-06 10:02:32'),
(24, 4, 'Login', 'User logged in successfully', '2025-05-06 10:04:36'),
(25, 4, 'Login', 'User logged in successfully', '2025-05-06 10:08:15'),
(26, 4, 'Login', 'User logged in successfully', '2025-05-06 10:10:11'),
(27, 4, 'Login', 'User logged in successfully', '2025-05-06 11:40:57'),
(28, 4, 'Login', 'User logged in successfully', '2025-05-06 11:41:44'),
(29, 4, 'Login', 'User logged in successfully', '2025-05-06 11:42:47'),
(30, 4, 'Login', 'User logged in successfully', '2025-05-06 11:45:21'),
(31, 4, 'Login', 'User logged in successfully', '2025-05-06 12:00:26'),
(32, 4, 'Login', 'User logged in successfully', '2025-05-06 12:15:39'),
(33, 4, 'Login', 'User logged in successfully', '2025-05-06 12:17:50'),
(34, 3, 'Login', 'User logged in successfully', '2025-05-06 14:36:32'),
(35, 3, 'Login', 'User logged in successfully', '2025-05-14 03:49:24'),
(36, 5, 'Login', 'User logged in successfully', '2025-05-14 03:52:38'),
(37, 5, 'Login', 'User logged in successfully', '2025-05-14 03:58:53'),
(38, 3, 'Login', 'User logged in successfully', '2025-05-18 02:32:26'),
(39, 3, 'Logout', 'User logged out successfully', '2025-05-18 02:33:37'),
(40, 3, 'Login', 'User logged in successfully', '2025-05-18 02:35:47'),
(41, 5, 'Login', 'User logged in successfully', '2025-05-18 04:49:09'),
(42, 3, 'Login', 'User logged in successfully', '2025-05-18 05:30:42'),
(43, 5, 'Login', 'User logged in successfully', '2025-05-18 05:32:08'),
(44, 3, 'Login', 'User logged in successfully', '2025-05-18 12:45:22'),
(45, 3, 'Login', 'User logged in successfully', '2025-05-18 12:49:33'),
(46, 3, 'Login', 'User logged in successfully', '2025-05-18 12:52:32'),
(47, 3, 'Login', 'User logged in successfully', '2025-05-18 13:14:25'),
(48, 3, 'Login', 'User logged in successfully', '2025-05-18 13:16:49'),
(49, 3, 'Login', 'User logged in successfully', '2025-05-18 13:19:22'),
(50, 3, 'Login', 'User logged in successfully', '2025-05-18 13:27:05'),
(51, 3, 'Login', 'User logged in successfully', '2025-05-18 13:29:58'),
(52, 3, 'Login', 'User logged in successfully', '2025-05-18 14:00:53'),
(53, 3, 'Login', 'User logged in successfully', '2025-05-18 14:05:28');

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
(3, 'Dray', 'Misa', 'jay@gmail.con', 'Dray', '+DWqqT508rt0Z92IyfDnOW4nJzG53cNQ7N50xGNLNPM=', 'Admin', 'Active', '2025-05-05 02:22:58', '2025-05-18 13:14:13'),
(4, 'Kris Jaylon', 'Mantillas', 'jaylon@gmail.com', 'jaylon', 'x3Xnt1ft5jDNCqERO9ECZhqziCnKUqZCKreChi8mhkY=', 'User', 'Active', '2025-05-06 09:29:08', '2025-05-06 09:29:45'),
(7, 'Dranreb', 'Misa', 'misadray3@gmail.com', 'Dranreb', '0tLCWgtLLuIq00rr/ysNBLzxA+HvbcVCScJVjXwFKfE=', 'User', 'Active', '2025-05-18 08:26:23', '2025-05-18 13:08:56'),
(9, 'Draniel', 'Misa', 'misadranreb4@gmail.com', 'Draniel', 'ovwnnU15vOKI/E5ty+0U8/2rJXxg1HsKdD+OBs4Fcqs=', 'Admin', 'Active', '2025-05-18 13:08:08', '2025-05-18 13:08:49');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `tbl_registeruser`
--
ALTER TABLE `tbl_registeruser`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
