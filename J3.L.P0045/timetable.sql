
use [timetables]
GO
/****** Object:  Database [timetables]    Script Date: 7/26/2021 12:34:32 PM ******/
CREATE DATABASE [timetables] ON  PRIMARY 
( NAME = N'timetables', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\timetables.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'timetables_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\timetables_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [timetables].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [timetables] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [timetables] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [timetables] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [timetables] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [timetables] SET ARITHABORT OFF 
GO
ALTER DATABASE [timetables] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [timetables] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [timetables] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [timetables] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [timetables] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [timetables] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [timetables] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [timetables] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [timetables] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [timetables] SET  DISABLE_BROKER 
GO
ALTER DATABASE [timetables] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [timetables] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [timetables] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [timetables] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [timetables] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [timetables] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [timetables] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [timetables] SET RECOVERY FULL 
GO
ALTER DATABASE [timetables] SET  MULTI_USER 
GO
ALTER DATABASE [timetables] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [timetables] SET DB_CHAINING OFF 
GO
EXEC sys.sp_db_vardecimal_storage_format N'timetables', N'ON'
GO
USE [timetables]
GO
/****** Object:  Table [dbo].[Class]    Script Date: 7/26/2021 12:34:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Class](
	[ClassId] [int] NOT NULL,
	[ClassName] [nvarchar](50) NULL,
 CONSTRAINT [PK_Class] PRIMARY KEY CLUSTERED 
(
	[ClassId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 7/26/2021 12:34:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[RoomId] [int] NOT NULL,
	[RoomName] [nvarchar](50) NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[RoomId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Slot]    Script Date: 7/26/2021 12:34:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Slot](
	[SlotId] [int] NOT NULL,
	[StartTime] [nvarchar](50) NULL,
	[EndTime] [nvarchar](50) NULL,
 CONSTRAINT [PK_Slot] PRIMARY KEY CLUSTERED 
(
	[SlotId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[timetable]    Script Date: 7/26/2021 12:34:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[timetable](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Date] [date] NULL,
	[SlotId] [int] NULL,
	[RoomId] [int] NULL,
	[Teacher] [nvarchar](50) NULL,
	[ClassId] [int] NULL,
 CONSTRAINT [PK_timetable] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Class] ([ClassId], [ClassName]) VALUES (1, N'SE1420')
INSERT [dbo].[Class] ([ClassId], [ClassName]) VALUES (2, N'SE1421')
INSERT [dbo].[Class] ([ClassId], [ClassName]) VALUES (3, N'SE1422')
INSERT [dbo].[Class] ([ClassId], [ClassName]) VALUES (4, N'SE1423')
INSERT [dbo].[Class] ([ClassId], [ClassName]) VALUES (5, N'SE1424')
INSERT [dbo].[Class] ([ClassId], [ClassName]) VALUES (6, N'SE1425')
INSERT [dbo].[Class] ([ClassId], [ClassName]) VALUES (7, N'SE1426')
GO
INSERT [dbo].[Room] ([RoomId], [RoomName]) VALUES (1, N'302')
INSERT [dbo].[Room] ([RoomId], [RoomName]) VALUES (2, N'303')
INSERT [dbo].[Room] ([RoomId], [RoomName]) VALUES (3, N'304')
INSERT [dbo].[Room] ([RoomId], [RoomName]) VALUES (4, N'305')
INSERT [dbo].[Room] ([RoomId], [RoomName]) VALUES (5, N'202')
INSERT [dbo].[Room] ([RoomId], [RoomName]) VALUES (6, N'203')
GO
INSERT [dbo].[Slot] ([SlotId], [StartTime], [EndTime]) VALUES (1, N'07h30''', N'08h15''')
INSERT [dbo].[Slot] ([SlotId], [StartTime], [EndTime]) VALUES (2, N'08h20''', N'09h05''')
INSERT [dbo].[Slot] ([SlotId], [StartTime], [EndTime]) VALUES (3, N'09h15''', N'10h00''')
INSERT [dbo].[Slot] ([SlotId], [StartTime], [EndTime]) VALUES (4, N'10h05''', N'10h50''')
INSERT [dbo].[Slot] ([SlotId], [StartTime], [EndTime]) VALUES (5, N'13h25''', N'14h10''')
INSERT [dbo].[Slot] ([SlotId], [StartTime], [EndTime]) VALUES (6, N'14h15''', N'15h00''')
INSERT [dbo].[Slot] ([SlotId], [StartTime], [EndTime]) VALUES (7, N'15h10''', N'15h55''')
GO
SET IDENTITY_INSERT [dbo].[timetable] ON 

INSERT [dbo].[timetable] ([id], [Date], [SlotId], [RoomId], [Teacher], [ClassId]) VALUES (1, CAST(N'2021-07-26' AS Date), 1, 1, N'Tung Chu', 1)
INSERT [dbo].[timetable] ([id], [Date], [SlotId], [RoomId], [Teacher], [ClassId]) VALUES (2, CAST(N'2021-07-26' AS Date), 2, 3, N'Teacher', 3)
INSERT [dbo].[timetable] ([id], [Date], [SlotId], [RoomId], [Teacher], [ClassId]) VALUES (3, CAST(N'2021-07-27' AS Date), 3, 3, N'Student', 3)
INSERT [dbo].[timetable] ([id], [Date], [SlotId], [RoomId], [Teacher], [ClassId]) VALUES (4, CAST(N'2021-07-27' AS Date), 4, 4, N'KhaPD', 5)
INSERT [dbo].[timetable] ([id], [Date], [SlotId], [RoomId], [Teacher], [ClassId]) VALUES (5, CAST(N'2021-07-25' AS Date), 3, 5, N'LongCT', 3)
INSERT [dbo].[timetable] ([id], [Date], [SlotId], [RoomId], [Teacher], [ClassId]) VALUES (7, CAST(N'2021-07-27' AS Date), 5, 5, N'TrungNT', 5)
INSERT [dbo].[timetable] ([id], [Date], [SlotId], [RoomId], [Teacher], [ClassId]) VALUES (9, CAST(N'2021-07-26' AS Date), 5, 4, N'TrungNT', 6)
INSERT [dbo].[timetable] ([id], [Date], [SlotId], [RoomId], [Teacher], [ClassId]) VALUES (10, CAST(N'2021-07-27' AS Date), 6, 3, N'TrungNT', 5)
INSERT [dbo].[timetable] ([id], [Date], [SlotId], [RoomId], [Teacher], [ClassId]) VALUES (13, CAST(N'2021-07-28' AS Date), 7, 5, N'TungCT', 2)
INSERT [dbo].[timetable] ([id], [Date], [SlotId], [RoomId], [Teacher], [ClassId]) VALUES (14, CAST(N'2021-07-28' AS Date), 4, 4, N'TungCT', 6)
SET IDENTITY_INSERT [dbo].[timetable] OFF
GO
ALTER TABLE [dbo].[timetable]  WITH CHECK ADD  CONSTRAINT [FK_timetable_Class] FOREIGN KEY([ClassId])
REFERENCES [dbo].[Class] ([ClassId])
GO
ALTER TABLE [dbo].[timetable] CHECK CONSTRAINT [FK_timetable_Class]
GO
USE [master]
GO
ALTER DATABASE [timetables] SET  READ_WRITE 
GO
