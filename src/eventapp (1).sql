-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2025 at 08:48 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

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
-- Table structure for table `logs_2`
--

CREATE TABLE `logs_2` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) DEFAULT NULL,
  `actions` varchar(255) DEFAULT NULL,
  `details` text DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(4, 'Jaymaica', 'Narvasa', 'njaymaica@gmail.com', 'Maica', 'x3Xnt1ft5jDNCqERO9ECZhqziCnKUqZCKreChi8mhkY=', 'User', 'Active', '2025-05-06 09:29:08', '2025-05-19 06:37:14'),
(7, 'Dranreb', 'Misa', 'misadray3@gmail.com', 'Dranreb', '0tLCWgtLLuIq00rr/ysNBLzxA+HvbcVCScJVjXwFKfE=', 'User', 'Active', '2025-05-18 08:26:23', '2025-05-18 13:08:56'),
(9, 'Draniel', 'Misa', 'misadranreb4@gmail.com', 'Draniel', 'ovwnnU15vOKI/E5ty+0U8/2rJXxg1HsKdD+OBs4Fcqs=', 'Admin', 'Active', '2025-05-18 13:08:08', '2025-05-18 13:08:49');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bookings_user` (`user_name`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `logs_2`
--
ALTER TABLE `logs_2`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `logs_2`
--
ALTER TABLE `logs_2`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_registeruser`
--
ALTER TABLE `tbl_registeruser`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `fk_bookings_user` FOREIGN KEY (`user_name`) REFERENCES `tbl_registeruser` (`u_username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `logs_2`
--
ALTER TABLE `logs_2`
  ADD CONSTRAINT `logs_2_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_registeruser` (`u_id`);

--
-- Constraints for table `tbl_registeruser`
--
ALTER TABLE `tbl_registeruser`
  ADD CONSTRAINT `fk_tbl_registeruser_id` FOREIGN KEY (`u_id`) REFERENCES `events` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
