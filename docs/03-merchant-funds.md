# Merchant funds safeguarding: investigation

Date: 25 November 2026. Desk research. No contact with any provider, bank or regulator.

## The rule (primary text read)

Bank of Ghana **Notice BG/GOV/SEC/2026/43**, 6 November 2026, under section 101 of the Payment Systems and Services Act, 2019 (Act 987). [Notice page](https://www.bog.gov.gh/notice/notice-no-43-management-of-merchant-collection-funds-by-settlement-banks-and-payment-service-providers/) | [PDF](https://www.bog.gov.gh/wp-content/uploads/2026/11/Notice-No.43-MANAGEMENT-OF-MERCHANT-COLLECTION-FUNDS-BY-SETTLEMENT-BANKS-AND-PAYMENT-SERVICE-PROVIDERS.pdf)

Applies to payment service providers (PSPs) and settlement banks. Merchant funds stay the merchant's property until settled under the service level agreement (SLA).

**Not in the notice:** a reconciliation frequency, a transition period (it says to take immediate steps), report formats, or specific penalties.

## Clause to capability

The first column summarises the notice. The second is a **proposed** design, not a legal requirement.

| Clause | What a system could do |
|---|---|
| 1. Collections go to a designated settlement account, never mixed with operating money | Match every collection to a credit in that account; flag money that lands elsewhere or does not arrive |
| 2. Settle strictly within SLA periods | Per-merchant settlement calendar, due dates, breach alerts |
| 3. No withdrawal, pledge, lien or set-off except settlement and earned fees | Classify every debit; anything unexplained is a breach case |
| 4. Settlement banks keep the accounts for settlement only | A bank-side view with the same checks |
| 5. Fees move only as part of settlement, per agreement | Fee engine from agreed terms; compare expected and actual transfers |
| 6. Records, controls and audit trails | Append-only ledger, approvals, evidence pack |
| 7. Bank of Ghana may require account statements from settlement banks | Statement export for a chosen period |

**Central invariant (design proposal):** at any cut-off, money in designated accounts is at least the total owed to all merchants, and each merchant's share is traceable.

## What exists elsewhere

The UK introduced detailed safeguarding rules on 7 May 2026, including internal and external reconciliations each reconciliation day and prompt shortfall correction ([Osborne Clarke](https://www.osborneclarke.com/insights/six-day-fca-sets-out-reconciliation-rules-address-safeguarding-risks-uk-payment-and-e)). This is a useful design reference. It does not apply in Ghana.

| Vendor | Offer | Ghana on the page read? |
|---|---|---|
| [Aurum](https://aurum.solutions/resources/safeguarding-how-payment-and-e-money-firms-can-stay-compliant-with-cass-15) | Safeguarding and reconciliation software, UK and EEA | No |
| [Kani Payments](https://kanipayments.com/blog/fca-safeguarding-update-what-you-need-to-do-before-2026/) | UK safeguarding and reconciliation | No |
| [Safeheld](https://www.buckinghamcapitalconsulting.com/post/safeguarding-reconciliation-software-for-emis-and-payment-institutions) | Daily safeguarding reconciliations, UK | No |
| [Credrails](https://credrails.com/) | General reconciliation, appears live | No |

No Ghana-specific safeguarding product turned up in a few searches. That does not show none exists, and providers may use spreadsheets or in-house tools.

## Buyers

64 licensed PSPs at end 2025 ([payments report](https://www.bog.gov.gh/wp-content/uploads/2026/08/Payment-Systems-Annual-Report-2025-1.pdf)), plus settlement banks. How many collect for merchants is not known.

## Judgement

- **As an engineering project:** strong. Clear invariants, hard concurrency and ledger work, a real regulation to trace to.
- **As a business:** unproven. Small regulated market, slow sales, trust and security checks, and compliance is due now while a new product takes months.
- **Defensibility:** none yet.

## Unknowns

1. How providers comply today.
2. Whether the Bank of Ghana will set reconciliation or reporting formats later.
3. Real statement formats from settlement banks.
4. Whether any local vendor or bank already offers this.
5. Licensing or data duties for a vendor (needs legal advice).

## Proposed version 1

**In:** merchants and SLAs, collection and statement import (synthetic first), double-entry ledger, fee engine, settlement schedule, daily safeguarding check, breach cases with maker-checker, audit evidence export, several PSPs kept isolated.

**Out:** moving money, live bank or provider connections, settlement bank portal, mobile app.
