package com.javajedi.model.service

import com.javajedi.model.Company
import com.javajedi.model.User
import com.javajedi.model.repository.CompanyRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CompanyService(
    private val companyRepository: CompanyRepository
) {

    suspend fun saveCompany(company: Company): Company? {
       return companyRepository.save(company)
    }

    suspend fun findAllCompanies(): Flow<Company> = companyRepository.findAll()

    suspend fun findById(id: Long): Company? = companyRepository.findById(id)

    suspend fun deleteById(id: Long) {
        companyRepository.deleteById(id)
    }

    suspend fun updateById(id: Long, companyRequest: Company) {
        val company = companyRepository.findById(id) ?: throw throw ResponseStatusException(HttpStatus.NOT_FOUND)
        companyRepository.save(
            companyRequest.copy(id = company.id)
        )
    }

    suspend fun findByNameLike(name: String): Flow<Company> = companyRepository.findByNameContaining(name)

}