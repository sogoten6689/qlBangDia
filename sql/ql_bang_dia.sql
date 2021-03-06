USE [master]
GO
/****** Object:  Database [BangDia]    Script Date: 11/17/2018 10:22:33 PM ******/
CREATE DATABASE [BangDia]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BangDia', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\BangDia.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'BangDia_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\BangDia_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [BangDia] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BangDia].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BangDia] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BangDia] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BangDia] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BangDia] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BangDia] SET ARITHABORT OFF 
GO
ALTER DATABASE [BangDia] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BangDia] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [BangDia] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BangDia] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BangDia] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BangDia] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BangDia] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BangDia] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BangDia] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BangDia] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BangDia] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BangDia] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BangDia] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BangDia] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BangDia] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BangDia] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BangDia] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BangDia] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BangDia] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BangDia] SET  MULTI_USER 
GO
ALTER DATABASE [BangDia] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BangDia] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BangDia] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BangDia] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [BangDia]
GO
/****** Object:  Table [dbo].[ChiTietPhieuThue]    Script Date: 11/17/2018 10:22:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuThue](
	[maCTPhieuThue] [nvarchar](50) NOT NULL,
	[maPhieuThue] [nvarchar](50) NULL,
	[maKh] [nvarchar](50) NULL,
	[ngayThue] [date] NULL,
	[ngayTra] [date] NULL,
	[soNgayThue] [int] NULL,
	[gia] [float] NULL,
	[maDia] [nvarchar](50) NULL,
	[tinhTrang] [nchar](10) NULL,
 CONSTRAINT [PK_ChiTietPhieuThue] PRIMARY KEY CLUSTERED 
(
	[maCTPhieuThue] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Dia]    Script Date: 11/17/2018 10:22:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dia](
	[maDia] [nvarchar](50) NOT NULL,
	[maTieuDe] [nvarchar](50) NOT NULL,
	[tinhTrang] [int] NOT NULL,
 CONSTRAINT [PK_Dia] PRIMARY KEY CLUSTERED 
(
	[maDia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/17/2018 10:22:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](250) NOT NULL,
	[tenKH] [nvarchar](50) NOT NULL,
	[soDT] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhieuDat]    Script Date: 11/17/2018 10:22:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDat](
	[maPhieuDat] [nvarchar](50) NOT NULL,
	[maTieuDe] [nvarchar](50) NULL,
	[maKH] [nvarchar](50) NULL,
	[soNgayThue] [int] NULL,
	[trangThai] [int] NULL,
	[gia] [float] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhieuThue]    Script Date: 11/17/2018 10:22:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuThue](
	[maPhieuThue] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NOT NULL,
	[ngayThue] [date] NOT NULL,
	[tongTien] [float] NOT NULL,
 CONSTRAINT [PK_PhieuThue] PRIMARY KEY CLUSTERED 
(
	[maPhieuThue] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhieuTre]    Script Date: 11/17/2018 10:22:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuTre](
	[maTre] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NULL,
	[Dia] [nvarchar](50) NULL,
	[tienTre] [float] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TieuDe]    Script Date: 11/17/2018 10:22:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TieuDe](
	[IdTieuDe] [nvarchar](50) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[NoiDung] [nvarchar](200) NOT NULL,
	[BangSao] [int] NOT NULL,
	[DaThue] [int] NOT NULL,
	[Gia] [float] NOT NULL,
 CONSTRAINT [PK_TieuDe] PRIMARY KEY CLUSTERED 
(
	[IdTieuDe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[ChiTietPhieuThue] ([maCTPhieuThue], [maPhieuThue], [maKh], [ngayThue], [ngayTra], [soNgayThue], [gia], [maDia], [tinhTrang]) VALUES (N'CTPT001', N'PT001', N'0907484852', CAST(N'2018-11-16' AS Date), NULL, 3, 700000, N'P10101', N'0         ')
INSERT [dbo].[ChiTietPhieuThue] ([maCTPhieuThue], [maPhieuThue], [maKh], [ngayThue], [ngayTra], [soNgayThue], [gia], [maDia], [tinhTrang]) VALUES (N'CTPT002', N'PT001', N'0907484852', CAST(N'2018-11-16' AS Date), NULL, 2, 700000, N'P10121', N'0         ')
INSERT [dbo].[Dia] ([maDia], [maTieuDe], [tinhTrang]) VALUES (N'P10101', N'P1010', 1)
INSERT [dbo].[Dia] ([maDia], [maTieuDe], [tinhTrang]) VALUES (N'P10102', N'P1010', 0)
INSERT [dbo].[Dia] ([maDia], [maTieuDe], [tinhTrang]) VALUES (N'P10103', N'P1010', 0)
INSERT [dbo].[Dia] ([maDia], [maTieuDe], [tinhTrang]) VALUES (N'P10111', N'P1011', 0)
INSERT [dbo].[Dia] ([maDia], [maTieuDe], [tinhTrang]) VALUES (N'P10112', N'P1011', 0)
INSERT [dbo].[Dia] ([maDia], [maTieuDe], [tinhTrang]) VALUES (N'P10113', N'P1011', 0)
INSERT [dbo].[Dia] ([maDia], [maTieuDe], [tinhTrang]) VALUES (N'P10121', N'P1012', 1)
INSERT [dbo].[Dia] ([maDia], [maTieuDe], [tinhTrang]) VALUES (N'P10122', N'P1012', 0)
INSERT [dbo].[Dia] ([maDia], [maTieuDe], [tinhTrang]) VALUES (N'P10123', N'P1012', 0)
INSERT [dbo].[KhachHang] ([maKH], [diaChi], [tenKH], [soDT]) VALUES (N'0789600746', N'Bình Long', N'Đau', N'0789600746')
INSERT [dbo].[KhachHang] ([maKH], [diaChi], [tenKH], [soDT]) VALUES (N'0789600766', N'195 Go Xoai', N'Ngoc Lam', N'0789600766')
INSERT [dbo].[KhachHang] ([maKH], [diaChi], [tenKH], [soDT]) VALUES (N'0907484852', N'101 Quang trung, Go Vap', N'Nhu My', N'0907484852')
INSERT [dbo].[KhachHang] ([maKH], [diaChi], [tenKH], [soDT]) VALUES (N'0908070612', N'Nguyen Thai Son', N'Tuan Trung', N'0908070612')
INSERT [dbo].[PhieuThue] ([maPhieuThue], [maKH], [ngayThue], [tongTien]) VALUES (N'PT001', N'0907484852', CAST(N'2018-11-16' AS Date), 3500000)
INSERT [dbo].[PhieuTre] ([maTre], [maKH], [Dia], [tienTre]) VALUES (N'XPT5001', N'Ngoc Lam', N'2100000.0', 2100000)
INSERT [dbo].[TieuDe] ([IdTieuDe], [Ten], [NoiDung], [BangSao], [DaThue], [Gia]) VALUES (N'P1010', N'Trân Châu Cảng', N'phim cực hay', 3, 1, 700000)
INSERT [dbo].[TieuDe] ([IdTieuDe], [Ten], [NoiDung], [BangSao], [DaThue], [Gia]) VALUES (N'P1011', N'Thần bài', N'phim cực hay', 3, 0, 700000)
INSERT [dbo].[TieuDe] ([IdTieuDe], [Ten], [NoiDung], [BangSao], [DaThue], [Gia]) VALUES (N'P1012', N'Tây du kí', N'phim cực hay', 3, 1, 700000)
ALTER TABLE [dbo].[ChiTietPhieuThue]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuThue_Dia] FOREIGN KEY([maDia])
REFERENCES [dbo].[Dia] ([maDia])
GO
ALTER TABLE [dbo].[ChiTietPhieuThue] CHECK CONSTRAINT [FK_ChiTietPhieuThue_Dia]
GO
ALTER TABLE [dbo].[ChiTietPhieuThue]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuThue_KhachHang] FOREIGN KEY([maKh])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[ChiTietPhieuThue] CHECK CONSTRAINT [FK_ChiTietPhieuThue_KhachHang]
GO
ALTER TABLE [dbo].[ChiTietPhieuThue]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuThue_PhieuThue] FOREIGN KEY([maPhieuThue])
REFERENCES [dbo].[PhieuThue] ([maPhieuThue])
GO
ALTER TABLE [dbo].[ChiTietPhieuThue] CHECK CONSTRAINT [FK_ChiTietPhieuThue_PhieuThue]
GO
ALTER TABLE [dbo].[Dia]  WITH CHECK ADD  CONSTRAINT [FK_Dia_TieuDe] FOREIGN KEY([maTieuDe])
REFERENCES [dbo].[TieuDe] ([IdTieuDe])
GO
ALTER TABLE [dbo].[Dia] CHECK CONSTRAINT [FK_Dia_TieuDe]
GO
USE [master]
GO
ALTER DATABASE [BangDia] SET  READ_WRITE 
GO
