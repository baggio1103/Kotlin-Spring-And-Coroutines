package com.javajedi.service

import com.javajedi.model.Company
import com.javajedi.repository.CompanyRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CompanyService(
    private val companyRepository: CompanyRepository
) {

    suspend fun saveCompany(company: Company): Company {
        return companyRepository.save(company) ?: throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    suspend fun findAll(): Flow<Company> = companyRepository.findAll()

    suspend fun findById(id: Long): Company = companyRepository.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    suspend fun deleteById(id: Long) {
        companyRepository.deleteById(id)
    }

    suspend fun updateById(id: Long, companyRequest: Company) {
        val company = companyRepository.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        companyRepository.save(
            companyRequest.copy(id = company.id)
        )
    }

    suspend fun findByNameLike(name: String): Flow<Company> = companyRepository.findByNameContaining(name)

}