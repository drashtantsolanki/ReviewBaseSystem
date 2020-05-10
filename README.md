# ReviewBaseSystem

# Category
 1. getAllCategory
 2. getCategoryById
 3. getCategoryByName
 4. addCategory
 5. updateCategory
 6. removeCategory


# CategoryRatingCriteria
1. getAllCategoryRatingCriteria
2. getCategoryRatingCriteriaById
3. getCategoryRatingCriteriaByCategoryId
4. getCategoryRatingCriteriaByRatingCriteriaId
5. addCategoryRatingCriteria
6. updateCategoryRatingCriteria
7. removeCategoryRatingCriteria

# Product
1. getAllProduct
2. getProductById
3. getProductByProductName
4. getProductByCategoryId
5. addProduct
6. updateProduct
7. removeProduct


# RatingCriteria
1. getAllRatingCriteria
2. getRatingCriteriaById
3. getRatingCriteriaByCriteriaName
4. addRatingCriteria
5. updateRatingCriteria
6. removeRatingCriteria


# Reviews
1. getAllReviews
2. getReviewById
3. getReviewByProductID
4. getReviewByDate
5. getReviewByUserId
6. addReview
7. updateReview
8. removeReview

# ReviewxCriteria
1. getAllReviewxCriteria
2. getReviewxCriteriaById
3. getReviewxCriteriaByRate
4. getReviewxCriteriaByCategoryRatingCriteriaId
5. getReviewxCriteriaByReviewId
6. addReviewxCriteria
7. updateReviewxCriteria
8. removeReviewxCriteria

# Role
1. getAllRoles
2. getRoleById
3. getRoleByName
4. addRole
5. updateRole
6. removeRole

# RolePermission
1. getAllRolePermission
2. getRolePermissionById
3. getRolePermissionByRoleId
4. getRolePermissionByPermissionId
5. addRolePermission
6. updateRolePermission
7. removeRolePermission

# Users
1. getAllUsers
2. getUserById
3. getUserByName
4. getUserByEmail
5. getUserByCity
6. addUser
7. updateUser
8. removeUser
9. getEncryptedPassword

# Author
1. getAllAuthors
2. getAuthorById
3. getAuthorByName
4. addAuthor
5. updateAuthor
6. removeAuthor

# Company   
1. getAllCompanies
2. addCompany
3. updateCompany
4. removeCompany
5. getCompanyId
6. getCompanyByName

# Genre
1. getAllGenres
2. getGenreById
3. getGenreByName
4. addGenre
5. updateGenre
6. removeGenre

# Publisher
1. getAllPublisher
2. getPublisherById
3. getPublisherByName
4. addPublisher
5. updatePublisher
6. removePublisher

# Advertise
1. getAllAdvertise
2. getAdvertiseById
3. getAdvertiseByProductId
4. getAdvertiseByDate(Date) (if advertise is exists between start date and end date)
5. addAdvertise
6. updateAdvertise
7. removeAdvertise

# UserRole
1. getAllUserRole
2. getUserRoleById
3. getUserRoleByUserId
4. getUserRoleByRoleId
5. addUserRole
6. updateUserRole
7. removeUserRole

# Permission
1. getAllPermissions
2. getPermissionById
3. getPermissionByName
4. addPermission
5. updatePermission
6. deletePermission
    
# Admin module:
1. Product
2. Category
3. Role
4. Permission
5. RolePermission
6. UserRole
7. CategoryRatingCriteria
8. RatingCriteria

# Client module:
1. User
2. Reviews
3. ReviewXCriteria
4. Advertisement


# Comman module:
1. Genre
2. Company
3. Author
4. Publisher

# Ejb name:
1. adminejb
2. clientejb
3. commanejb
