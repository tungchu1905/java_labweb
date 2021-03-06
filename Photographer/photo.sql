
USE [Photographer]
GO
/****** Object:  Table [dbo].[Gallery]    Script Date: 5/17/2021 7:22:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gallery](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[description] [nvarchar](max) NULL,
	[image] [nvarchar](50) NULL,
 CONSTRAINT [PK_Gallery] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ImageGallery]    Script Date: 5/17/2021 7:22:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImageGallery](
	[image] [nvarchar](50) NOT NULL,
	[gallery_id] [int] NOT NULL,
 CONSTRAINT [PK_ImageGallery] PRIMARY KEY CLUSTERED 
(
	[image] ASC,
	[gallery_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Information]    Script Date: 5/17/2021 7:22:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
drop table Information
CREATE TABLE [dbo].[Information](
	[address] [nvarchar](max) NULL,
	[city] [nvarchar](max) NULL,
	[country] [nvarchar](50) NULL,
	[tel] [nvarchar](50) NULL,
	[email] [nvarchar](max) NULL,
	[image] [nvarchar](50) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Intro]    Script Date: 5/17/2021 7:22:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Intro](
	[image] [nvarchar](50) NULL,
	[entry] [nvarchar](max) NULL,
	[aboutme] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Share]    Script Date: 5/17/2021 7:22:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Share](
	[icon] [nvarchar](50) NULL,
	[social_network] [nvarchar](50) NOT NULL,
	[url] [nvarchar](max) NULL,
 CONSTRAINT [PK_Share] PRIMARY KEY CLUSTERED 
(
	[social_network] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[View]    Script Date: 5/17/2021 7:22:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[View](
	[viewed] [int] NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Gallery] ([id], [name], [description], [image]) VALUES (1, N'Gallery 1', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'anh1.jpg')
GO
INSERT [dbo].[Gallery] ([id], [name], [description], [image]) VALUES (2, N'Gallery 2', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'anh2.jpg')
GO
INSERT [dbo].[Gallery] ([id], [name], [description], [image]) VALUES (3, N'Gallery 3', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'anh3.jpg')
GO
INSERT [dbo].[Gallery] ([id], [name], [description], [image]) VALUES (4, N'Gallery 4', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'anh3.jpg')
GO

INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh0.jpg', 1)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh0.jpg', 2)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh0.jpg', 3)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh0.jpg', 4)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh1.jpg', 1)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh1.jpg', 2)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh1.jpg', 3)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh1.jpg', 4)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh2.jpg', 1)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh2.jpg', 2)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh2.jpg', 3)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh2.jpg', 4)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh3.jpg', 1)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh3.jpg', 2)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh3.jpg', 3)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh3.jpg', 4)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh4.jpg', 1)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh4.jpg', 2)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh4.jpg', 3)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh4.jpg', 4)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh5.jpg', 1)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh5.jpg', 2)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh5.jpg', 3)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh5.jpg', 4)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh6.jpg', 1)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh6.jpg', 2)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh6.jpg', 3)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh6.jpg', 4)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh7.jpg', 1)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh7.jpg', 2)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh7.jpg', 3)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh7.jpg', 4)
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh8.jpg', 2)
GO
INSERT [dbo].[Information] ([address], [city], [country], [tel], [email], [image]) VALUES (N'Km29 Dai Lo Thang Long - Thach Hoa - Thach That', N'Ha Noi', N'Viet Nam', N'0338446955', N'tungcthe141487@fpt.edu.vn', N'vt.png')
GO
INSERT [dbo].[Intro] ([image], [entry], [aboutme]) VALUES (N'anh0.jpg', N'Lorem ipsum dolor sit amet', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim')
GO
INSERT [dbo].[Share] ([icon], [social_network], [url]) VALUES (N'fb.png', N'Facebook', N'https://www.facebook.com/')
GO
INSERT [dbo].[Share] ([icon], [social_network], [url]) VALUES (N'gg.png', N'Google+', N'https://www.google.com.vn/')
GO
INSERT [dbo].[Share] ([icon], [social_network], [url]) VALUES (N'tw.png', N'Twitter', N'https://twitter.com/')
GO

INSERT [dbo].[View] ([viewed]) VALUES (0)
GO
select * from [dbo].[View]
ALTER TABLE [dbo].[ImageGallery]  WITH CHECK ADD  CONSTRAINT [FK_ImageGallery_Gallery] FOREIGN KEY([gallery_id])
REFERENCES [dbo].[Gallery] ([id])
GO
ALTER TABLE [dbo].[ImageGallery] CHECK CONSTRAINT [FK_ImageGallery_Gallery]
GO
